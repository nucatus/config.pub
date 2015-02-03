package pub.config.godfather.domain;

import java.util.Date;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
public class ActionHistory
{

    private Date actionDate;
    private Operation operation;
    private User operator;

    public Date getActionDate()
    {
        return actionDate;
    }

    public void setActionDate(Date actionDate)
    {
        this.actionDate = actionDate;
    }

    public Operation getOperation()
    {
        return operation;
    }

    public void setOperation(Operation operation)
    {
        this.operation = operation;
    }

    public User getOperator()
    {
        return operator;
    }

    public void setOperator(User operator)
    {
        this.operator = operator;
    }
}
