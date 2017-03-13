package com.atlassian.clover.idea;

import com.intellij.openapi.project.Project;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Access the ProjectPlugin class using reflections (to avoid having dependency clover-idea-optimizer => clover-idea
 */
public class ProjectPluginViaReflection {
    public static IProjectPlugin getPlugin(Project project) {
        try {
            // return ProjectPlugin.getPlugin(project);
            Class<?> projectPlugin = Class.forName("com.atlassian.clover.idea.ProjectPlugin");
            Method getPlugin = projectPlugin.getMethod("getPlugin", Project.class);
            return (IProjectPlugin)getPlugin.invoke(null, project);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (ClassCastException e) {
            return null;
        }
    }
}
