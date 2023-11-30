import re
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.edge.service import Service
from webdriver_manager.microsoft import EdgeChromiumDriverManager
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By

find_name=re.compile(r'target="_self">(.*?)</a>')
find_symb=re.compile(r'症状：(.*?)</font>')

option=webdriver.ChromeOptions()
option.add_argument('--log-level=3')
option.add_argument('--headless')  # 开启无界面模式
# option.add_argument("--disable-gpu") 

choose=2
if choose==1:
    borwers=webdriver.Edge(service=Service(EdgeChromiumDriverManager.install()),options=option)
elif choose==2:
    borwers=webdriver.Chrome(service=Service(ChromeDriverManager.install()),options=option)

borwers.get('https://jibing.bmcx.com/')

buttom=input()
values=buttom.split(',')
for i in values:
    if i=='':
        continue
    borwers.find_element(By.XPATH,'//*[@id="x_z_k"]/ul[1]/li['+i+']/label/input').click()
borwers.find_element(By.ID,'button').click()

ul=borwers.find_element(By.CLASS_NAME,'list')
lis=ul.find_elements(By.TAG_NAME,'li')
for i in lis[:6]:
    print(i.text)

borwers.quit()