import re
import requests
from bs4 import BeautifulSoup


find_name=re.compile(r'">(.*?)</a><br/>')
find_symb=re.compile(r'"#999999">(.*?)</font></li>')


button=input()
button=button.split(',')
val=''
desc={'1':'消瘦','2':',休克','3':',血尿','4':',糖尿'}
for i in button:
    if i=='':continue
    if i in desc:
        val+=desc[i]
            

url='https://jibing.bmcx.com/'+val+'__jibing/'
headers={'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36'}
gethtml=requests.get(url,headers)
soup=BeautifulSoup(gethtml.text,'lxml')

for i in range(1,6):
    sick=soup.select('#main_content > ul > li:nth-child('+str(i)+')')
    if sick==[]:break
    sickname=re.findall(find_name,str(sick[0]))[0]
    sicksymp=re.findall(find_symb,str(sick[0]))[0]
    print(sickname+'\n'+sicksymp)

