-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cargo` VARCHAR(45) NULL,
  `salario` FLOAT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoAula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TipoAula` (
  `idTipoAula` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `horario` VARCHAR(45) NULL,
  `local` VARCHAR(45) NULL,
  `capacidade` INT NULL,
  PRIMARY KEY (`idTipoAula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Academia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Academia` (
  `idAcademia` VARCHAR(5) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `horarioFuncionamento` VARCHAR(45) NULL,
  `Funcionario_cpf` VARCHAR(11) NOT NULL,
  `TipoAula_idTipoAula` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAcademia`),
  INDEX `fk_Academia_Funcionario_idx` (`Funcionario_cpf` ASC) VISIBLE,
  INDEX `fk_Academia_TipoAula1_idx` (`TipoAula_idTipoAula` ASC) VISIBLE,
  CONSTRAINT `fk_Academia_Funcionario`
    FOREIGN KEY (`Funcionario_cpf`)
    REFERENCES `mydb`.`Funcionario` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Academia_TipoAula1`
    FOREIGN KEY (`TipoAula_idTipoAula`)
    REFERENCES `mydb`.`TipoAula` (`idTipoAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professor` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `dataEfetivacao` DATE NULL,
  `tipoAula` VARCHAR(45) NULL,
  `turno` VARCHAR(45) NULL,
  `salario` FLOAT NULL,
  `TipoAula_idTipoAula` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`),
  INDEX `fk_Professor_TipoAula1_idx` (`TipoAula_idTipoAula` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_TipoAula1`
    FOREIGN KEY (`TipoAula_idTipoAula`)
    REFERENCES `mydb`.`TipoAula` (`idTipoAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aluno` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `dataNascimento` DATE NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `aulasCadastradas` VARCHAR(45) NULL,
  `TipoAula_idTipoAula` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`, `TipoAula_idTipoAula`),
  INDEX `fk_Aluno_TipoAula1_idx` (`TipoAula_idTipoAula` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_TipoAula1`
    FOREIGN KEY (`TipoAula_idTipoAula`)
    REFERENCES `mydb`.`TipoAula` (`idTipoAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pagamento` (
  `idPagamento` VARCHAR(45) NOT NULL,
  `data` DATE NULL,
  `valor` FLOAT NULL,
  `tipoPlano` VARCHAR(45) NULL,
  `tipoPagamento` VARCHAR(45) NULL,
  `Aluno_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idPagamento`),
  INDEX `fk_Pagamento_Aluno1_idx` (`Aluno_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_Pagamento_Aluno1`
    FOREIGN KEY (`Aluno_cpf`)
    REFERENCES `mydb`.`Aluno` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
