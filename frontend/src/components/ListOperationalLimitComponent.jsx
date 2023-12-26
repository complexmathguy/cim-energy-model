import React, { Component } from 'react'
import OperationalLimitService from '../services/OperationalLimitService'

class ListOperationalLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                operationalLimits: []
        }
        this.addOperationalLimit = this.addOperationalLimit.bind(this);
        this.editOperationalLimit = this.editOperationalLimit.bind(this);
        this.deleteOperationalLimit = this.deleteOperationalLimit.bind(this);
    }

    deleteOperationalLimit(id){
        OperationalLimitService.deleteOperationalLimit(id).then( res => {
            this.setState({operationalLimits: this.state.operationalLimits.filter(operationalLimit => operationalLimit.operationalLimitId !== id)});
        });
    }
    viewOperationalLimit(id){
        this.props.history.push(`/view-operationalLimit/${id}`);
    }
    editOperationalLimit(id){
        this.props.history.push(`/add-operationalLimit/${id}`);
    }

    componentDidMount(){
        OperationalLimitService.getOperationalLimits().then((res) => {
            this.setState({ operationalLimits: res.data});
        });
    }

    addOperationalLimit(){
        this.props.history.push('/add-operationalLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OperationalLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOperationalLimit}> Add OperationalLimit</button>
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
                                    this.state.operationalLimits.map(
                                        operationalLimit => 
                                        <tr key = {operationalLimit.operationalLimitId}>
                                             <td>
                                                 <button onClick={ () => this.editOperationalLimit(operationalLimit.operationalLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOperationalLimit(operationalLimit.operationalLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOperationalLimit(operationalLimit.operationalLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListOperationalLimitComponent
