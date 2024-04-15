package dev.earthly.plugin.language.syntax.parser;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import dev.earthly.plugin.metadata.EarthlyFileType;
import dev.earthly.plugin.metadata.EarthlyLanguage;
import org.jetbrains.annotations.NotNull;

public class EarthlyFile extends PsiFileBase {
  public EarthlyFile(FileViewProvider provider) {
    super(provider, EarthlyLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return EarthlyFileType.INSTANCE;
  }

  @Override
  public PsiReference @NotNull [] getReferences() {
    return ReferenceProvidersRegistry.getReferencesFromProviders(this);
  }
}
