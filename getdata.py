import re
import requests
from bs4 import BeautifulSoup


find_name=re.compile(r'">(.*?)</a><br/>')
find_symb=re.compile(r'"#999999">(.*?)</font></li>')


button=input()
button=button.split(',')
val=''
desc={}
reslist=["消瘦",",休克",",昏迷",",晕厥",",发热",",抽筋"\
    ,",疲劳",",贫血",",猝死",",瘫痪",",脱水",",身痛"\
    ,",腰背痛",",神经痛",",出汗异常",",体型异常",",癫痫和癫痫样发作"\
    ,",肥胖症",",感觉障碍",",佝楼病",",毛发异常",",肌肉萎缩"\
    ,",肌性肌无力",",脊柱和四肢畸形",",鼻出血",",鼻溢液",",恶心与呕吐",\
    ",耳痛",",耳鸣",",耳溢液",",呼吸异常","红眼",",呼吸衰竭",",颈肩痛",\
    ",口腔痛",",口臭",",溃疡",",咳痰",",咳嗽",",声音嘶哑",",食欲异常",\
    ",色素异常",",色觉异常",",眼痛",",眼球震颤",",眼球突出",",眼球内陷",\
    ",头痛",",听力减退",",瞳孔异常",",吞咽困难",",呕血",",颈静脉怒张",\
    ",角膜混浊",",咽痛",",咽炎、舌炎、龈炎",",言语障碍",",牙齿异常",",眼球运动障碍",\
    ",咽部异物感",",呃逆"]
for i in range(1,len(reslist)+1):
    desc[str(i)]=reslist[i-1]
for i in button:
    if i=='':continue
    if i in desc:
        val+=desc[i]
            

url='https://jibing.bmcx.com/'+val+'__jibing/'
headers={'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36'}
gethtml=requests.get(url,headers)
soup=BeautifulSoup(gethtml.text,'lxml')

for i in range(1,30):
    sick=soup.select('#main_content > ul > li:nth-child('+str(i)+')')
    if sick==[]:break
    sickname=re.findall(find_name,str(sick[0]))[0]
    sicksymp=re.findall(find_symb,str(sick[0]))[0]
    print(sickname+'\n'+sicksymp)

