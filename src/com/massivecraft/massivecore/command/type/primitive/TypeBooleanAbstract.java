package com.massivecraft.massivecore.command.type.primitive;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.massivecraft.massivecore.collections.MassiveSet;
import com.massivecraft.massivecore.command.type.TypeAbstractChoice;

public abstract class TypeBooleanAbstract extends TypeAbstractChoice<Boolean>
{
	// -------------------------------------------- //
	// CONSTANTS
	// -------------------------------------------- //
	
	public static final String NAME_YES = "Yes";
	public static final String NAME_TRUE = "True";
	public static final String NAME_ON = "On";
	
	public static final String NAME_NO = "No";
	public static final String NAME_FALSE = "False";
	public static final String NAME_OFF = "Off";
	
	public static final Set<String> NAMES_TRUE = new MassiveSet<String>(
		NAME_YES,
		NAME_TRUE,
		NAME_ON
	);
	
	public static final Set<String> NAMES_FALSE = new MassiveSet<String>(
		NAME_NO,
		NAME_FALSE,
		NAME_OFF
	);
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	protected final String stringTrue;
	public String getNameTrue() { return this.stringTrue; }
	
	protected final String stringFalse;
	public String getNameFalse() { return this.stringFalse; }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public TypeBooleanAbstract(String t, String f)
	{
		super(Boolean.class);
		this.stringTrue = t;
		this.stringFalse = f;
		this.setAll(
			Boolean.TRUE,
			Boolean.FALSE
		);
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public String getName()
	{
		return "toggle";
	}
	
	@Override
	public String getVisualInner(Boolean value, CommandSender sender)
	{
		String name = this.getNameInner(value);
		ChatColor color = (value ? ChatColor.GREEN : ChatColor.RED);
		return color + name;
	}
	
	@Override
	public String getNameInner(Boolean value)
	{
		return value ? this.getNameTrue() : this.getNameFalse();
	}
	
	@Override
	public Set<String> getNamesInner(Boolean value)
	{
		// Create
		Set<String> ret = new MassiveSet<String>();
		
		// Fill
		ret.add(this.getNameInner(value));
		ret.addAll(value ? NAMES_TRUE : NAMES_FALSE);
		
		// Return
		return ret;
	}
	
	@Override
	public String getIdInner(Boolean value)
	{
		return value.toString();
	}

}
