import React, { Component } from 'react'
import OperationalLimitTypeService from '../services/OperationalLimitTypeService'

class ListOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                operationalLimitTypes: []
        }
        this.addOperationalLimitType = this.addOperationalLimitType.bind(this);
        this.editOperationalLimitType = this.editOperationalLimitType.bind(this);
        this.deleteOperationalLimitType = this.deleteOperationalLimitType.bind(this);
    }

    deleteOperationalLimitType(id){
        OperationalLimitTypeService.deleteOperationalLimitType(id).then( res => {
            this.setState({operationalLimitTypes: this.state.operationalLimitTypes.filter(operationalLimitType => operationalLimitType.operationalLimitTypeId !== id)});
        });
    }
    viewOperationalLimitType(id){
        this.props.history.push(`/view-operationalLimitType/${id}`);
    }
    editOperationalLimitType(id){
        this.props.history.push(`/add-operationalLimitType/${id}`);
    }

    componentDidMount(){
        OperationalLimitTypeService.getOperationalLimitTypes().then((res) => {
            this.setState({ operationalLimitTypes: res.data});
        });
    }

    addOperationalLimitType(){
        this.props.history.push('/add-operationalLimitType/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OperationalLimitType List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOperationalLimitType}> Add OperationalLimitType</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> AcceptableDuration </th>
                                    <th> Direction </th>
                                    <th> LimitType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.operationalLimitTypes.map(
                                        operationalLimitType => 
                                        <tr key = {operationalLimitType.operationalLimitTypeId}>
                                             <td> { operationalLimitType.acceptableDuration } </td>
                                             <td> { operationalLimitType.direction } </td>
                                             <td> { operationalLimitType.limitType } </td>
                                             <td>
                                                 <button onClick={ () => this.editOperationalLimitType(operationalLimitType.operationalLimitTypeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOperationalLimitType(operationalLimitType.operationalLimitTypeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOperationalLimitType(operationalLimitType.operationalLimitTypeId)} className="btn btn-info btn-sm">View </button>
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

export default ListOperationalLimitTypeComponent
