import React, { Component } from 'react'
import OperationalLimitSetService from '../services/OperationalLimitSetService'

class ListOperationalLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                operationalLimitSets: []
        }
        this.addOperationalLimitSet = this.addOperationalLimitSet.bind(this);
        this.editOperationalLimitSet = this.editOperationalLimitSet.bind(this);
        this.deleteOperationalLimitSet = this.deleteOperationalLimitSet.bind(this);
    }

    deleteOperationalLimitSet(id){
        OperationalLimitSetService.deleteOperationalLimitSet(id).then( res => {
            this.setState({operationalLimitSets: this.state.operationalLimitSets.filter(operationalLimitSet => operationalLimitSet.operationalLimitSetId !== id)});
        });
    }
    viewOperationalLimitSet(id){
        this.props.history.push(`/view-operationalLimitSet/${id}`);
    }
    editOperationalLimitSet(id){
        this.props.history.push(`/add-operationalLimitSet/${id}`);
    }

    componentDidMount(){
        OperationalLimitSetService.getOperationalLimitSets().then((res) => {
            this.setState({ operationalLimitSets: res.data});
        });
    }

    addOperationalLimitSet(){
        this.props.history.push('/add-operationalLimitSet/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OperationalLimitSet List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOperationalLimitSet}> Add OperationalLimitSet</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.operationalLimitSets.map(
                                        operationalLimitSet => 
                                        <tr key = {operationalLimitSet.operationalLimitSetId}>
                                             <td>
                                                 <button onClick={ () => this.editOperationalLimitSet(operationalLimitSet.operationalLimitSetId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOperationalLimitSet(operationalLimitSet.operationalLimitSetId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOperationalLimitSet(operationalLimitSet.operationalLimitSetId)} className="btn btn-info btn-sm">View </button>
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

export default ListOperationalLimitSetComponent
