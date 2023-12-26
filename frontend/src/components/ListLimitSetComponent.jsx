import React, { Component } from 'react'
import LimitSetService from '../services/LimitSetService'

class ListLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                limitSets: []
        }
        this.addLimitSet = this.addLimitSet.bind(this);
        this.editLimitSet = this.editLimitSet.bind(this);
        this.deleteLimitSet = this.deleteLimitSet.bind(this);
    }

    deleteLimitSet(id){
        LimitSetService.deleteLimitSet(id).then( res => {
            this.setState({limitSets: this.state.limitSets.filter(limitSet => limitSet.limitSetId !== id)});
        });
    }
    viewLimitSet(id){
        this.props.history.push(`/view-limitSet/${id}`);
    }
    editLimitSet(id){
        this.props.history.push(`/add-limitSet/${id}`);
    }

    componentDidMount(){
        LimitSetService.getLimitSets().then((res) => {
            this.setState({ limitSets: res.data});
        });
    }

    addLimitSet(){
        this.props.history.push('/add-limitSet/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LimitSet List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLimitSet}> Add LimitSet</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> IsPercentageLimits </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.limitSets.map(
                                        limitSet => 
                                        <tr key = {limitSet.limitSetId}>
                                             <td> { limitSet.isPercentageLimits } </td>
                                             <td>
                                                 <button onClick={ () => this.editLimitSet(limitSet.limitSetId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLimitSet(limitSet.limitSetId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLimitSet(limitSet.limitSetId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListLimitSetComponent
