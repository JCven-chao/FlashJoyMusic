package com.team.flashjoymusic.data;

import java.util.List;
import lombok.Data;

@Data
public class Password{
	private String admin;
	private List<String> user;
}