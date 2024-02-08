from flask import Flask,render_template

import mq_communication

app = Flask(__name__)


def send_message(request):
    rabbit = mq_communication.RabbitMq()
    rabbit.send_message(request)


@app.route('/',methods=['GET','POST'])
def hello_world():  # put application's code here
    return render_template("index.html")


@app.route('/button1',methods=['GET','POST'])
def button1():  # put application's code here
    send_message("button1")
    return render_template("index.html")


@app.route('/button2',methods=['GET','POST'])
def button2():  # put application's code here
    send_message("button2")
    return render_template("index.html")


if __name__ == '__main__':
    app.run()
