package com.project.databaseaccess;

public class UserModel
{
	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getPhone()
	{
		return phone;
	}

	public void setPhone(int phone)
	{
		this.phone = phone;
	}
	
	public String toString()
	{
		return "U¿ytkownik: " + name + ' ' + surname;
	}
	
	private int user_id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private int phone;
}
