import pika


class RabbitMq:
    config = {
        'host': '0.0.0.0',
        'port': 5678,
        'username': 'student',
        'password': 'student',
        'exchange': 'buttonapp.direct',
        'routing_key': 'buttonapp.routingkey',
        'queue': 'buttonapp.queue'
    }
    credentials = pika.PlainCredentials(config['username'], config['password'])
    parameters = (pika.ConnectionParameters(host=config['host']),
                  pika.ConnectionParameters(port=config['port']),
                  pika.ConnectionParameters(credentials=credentials))

    def __init__(self):
        pass

    def send_message(self, message):
        # automatically close the connection
        with pika.BlockingConnection(self.parameters) as connection:
            # automatically close the channel
            with connection.channel() as channel:
                self.clear_queue(channel)
                channel.basic_publish(exchange=self.config['exchange'],
                                      routing_key=self.config['routing_key'],
                                      body=message)

    def clear_queue(self, channel):
        channel.queue_purge(self.config['queue'])
