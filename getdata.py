import time
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By


option=webdriver.ChromeOptions()
option.add_argument('--log-level=3')

borwers=webdriver.Chrome(options=option)

borwers.get('https://jibing.bmcx.com/')

buttom=input()
values=buttom.split(',')
for i in values:
    if i=='':
        continue
    borwers.find_element(By.XPATH,'//*[@id="x_z_k"]/ul[1]/li['+i+']/label/input').click()

time.sleep(10)