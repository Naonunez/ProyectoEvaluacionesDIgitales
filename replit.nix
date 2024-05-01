{ pkgs }: {
    deps = [
      pkgs.vimPlugins.LanguageClient-neovim
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}