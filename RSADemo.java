package com.zzuli.qipeng.demo;
import java.io.*;

import static java.lang.System.*;

public class RSADemo {
	private int p = 0;
	private int q = 0;
	private long n = 0;
	private long m = 0;
	private long public_ley = 0;	//��Կ
	private long private_key = 0;	//˽Կ
	private long text = 0;			//����
	private long secrtetword = 0;	//����
	private long word = 0;			//���ܺ�����
	
	private BufferedReader stdin = new BufferedReader(new InputStreamReader(in));
	
	public boolean isPrimenumber(long t) {
		long k = 0;
		k = (long)Math.sqrt((double)t);
		boolean flag = true;
		outer:
			for(int i = 2; i <= k; i++) {
				if((t % i) == 0){
					flag = false;
					break outer;
				}
			}
		return flag;
	}
	
	public void inputPQ() throws Exception {
		do{
			out.println("����������P:");
			String br = stdin.readLine();
			this.p = Integer.parseInt(br);
		} while(!isPrimenumber(this.p));
		
		do{
			out.println("����������Q:");
			String br = stdin.readLine();
			this.q = Integer.parseInt(br);
		} while(!isPrimenumber(this.q));
		
		this.n = this.p * this.q;
		this.m = (this.p - 1) * (this.q - 1);
		out.println("�����������ĳ˻�Ϊ�� " + this.n);
		out.println("���õ�С��N������N��Ϊ������֤��ĸ���Ϊ�� " +this.m);
	}
	
	public long gcd(long a, long b) {
		long gcd;
		if(b == 0)
			gcd = a;
		else {
			gcd = gcd(b, a % b);
		}
		out.println("���Լ����" + gcd);
		return gcd;
	}
	
	public void setPulbic_key() throws Exception{
		do{
			out.println("������һ����Կ��ֵ�����ֵҪ��С��m���Һ�m���ʣ�");
			String br = stdin.readLine();
			long public_key = Long.parseLong(br);
			this.public_ley = public_key;
		}while((this.public_ley >= this.m) || (this.gcd(this.m, this.public_ley) != 1));
		out.println("��ԿΪ��" + this.public_ley);
	}
	
	public void setPrivate_key() {
		long value = 1;
		outer:
			for(long i = 1;; i++){
				value = i * this.m + 1;
				out.println("value: " + value);
				if((value % this.public_ley == 0) && (value / this.public_ley < this.m)){
					this.private_key = value / this.public_ley;
					break outer;
				}
			}
		out.println("������һ��˽ԿΪ�� " + this.private_key);
	}
	
	public void setText() throws Exception {
		out.println("���������ģ� ");
		String br = stdin.readLine();
		this.text = Long.parseLong(br);
	}
	
	public long colum(long y, long n ,long key) {
		long mul;
		if(key == 1)
			mul = y % n;
		else {
			mul = y * this.colum(y, n, key - 1) % n;
		}
		return mul;
	}
	
	public void pascolum() throws Exception {
		this.setText();
		out.println("����Ϊ�� " + this.text);
		this.secrtetword = this.colum(this.text, this.n, this.public_ley);
		out.println("����Ϊ�� " + this.secrtetword);
		this.word = this.colum(this.secrtetword, this.n, this.private_key);
		out.println("���ܺ������Ϊ�� " + this.word);
	}
	
	public static void main(String[] args) throws Exception{
		RSADemo rsa = new RSADemo();
		rsa.inputPQ();
		rsa.setPulbic_key();
		rsa.setPrivate_key();
		rsa.pascolum();
	}
}
