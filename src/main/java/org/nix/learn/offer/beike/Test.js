let n =readInt();
for(let i=0;i<n;i++){
    let temp = read_line().split(' ');
    print(punch(temp));
}

function punch(arr) {
    let X=parseInt(arr[0]),A=parseInt(arr[1]),C=parseInt(arr[2]),Y=parseInt(arr[3]),B=parseInt(arr[4]),D=parseInt(arr[5]);
    let Xlast=-C,Ylast=-D,time=0;
    let Xhp=X,Yhp=Y;
    while (Xhp>0&&Yhp>0){
        if(Xlast+C==time){
            Yhp-=A;
            Xlast+=C;
        }
        if(Ylast+D==time){
            Xhp-=B;
            Ylast+=D;
        }
        time++;
    }
    if(Xhp<=0&&Yhp<=0)
        return 'TIE';
    else if(Xhp<=0)
        return 'XIAOCHUN';
    else if(Yhp<=0)
        return 'XIAOZHI';
}
