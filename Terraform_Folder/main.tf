terraform {
    required_providers {
        aws = {
            source = "hasicorp/aws"
            version = "~> 3.0"
        }
    }
}
provider "aws" {
    profile = default
    region  = "us-east-1"
}

data "aws" "default_vpc" {
    default = true

}
resource "aws_instance" "java_app_server" {
    ami             =
    instance_type   =
    security_groups = 
}

resource "aws_security_group" "sg_java_app" {
    name = "java_app_server_security group"
}

resource "aws_security_group_rule" "allow_http_inbound" {
    type              = "ingress"
    security_group_id = aws_security_group.sg_java_app.id 

    from_port   = 80
    to_port     = 80
    protocol    = "HTTP"
    cidr_blocks = ["0.0.0.0/0"]      
}