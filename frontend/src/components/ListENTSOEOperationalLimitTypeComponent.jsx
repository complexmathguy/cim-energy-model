import React, { Component } from 'react'
import ENTSOEOperationalLimitTypeService from '../services/ENTSOEOperationalLimitTypeService'

class ListENTSOEOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                eNTSOEOperationalLimitTypes: []
        }
        this.addENTSOEOperationalLimitType = this.addENTSOEOperationalLimitType.bind(this);
        this.editENTSOEOperationalLimitType = this.editENTSOEOperationalLimitType.bind(this);
        this.deleteENTSOEOperationalLimitType = this.deleteENTSOEOperationalLimitType.bind(this);
    }

    deleteENTSOEOperationalLimitType(id){
        ENTSOEOperationalLimitTypeService.deleteENTSOEOperationalLimitType(id).then( res => {
            this.setState({eNTSOEOperationalLimitTypes: this.state.eNTSOEOperationalLimitTypes.filter(eNTSOEOperationalLimitType => eNTSOEOperationalLimitType.eNTSOEOperationalLimitTypeId !== id)});
        });
    }
    viewENTSOEOperationalLimitType(id){
        this.props.history.push(`/view-eNTSOEOperationalLimitType/${id}`);
    }
    editENTSOEOperationalLimitType(id){
        this.props.history.push(`/add-eNTSOEOperationalLimitType/${id}`);
    }

    componentDidMount(){
        ENTSOEOperationalLimitTypeService.getENTSOEOperationalLimitTypes().then((res) => {
            this.setState({ eNTSOEOperationalLimitTypes: res.data});
        });
    }

    addENTSOEOperationalLimitType(){
        this.props.history.push('/add-eNTSOEOperationalLimitType/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ENTSOEOperationalLimitType List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addENTSOEOperationalLimitType}> Add ENTSOEOperationalLimitType</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> LimitType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.eNTSOEOperationalLimitTypes.map(
                                        eNTSOEOperationalLimitType => 
                                        <tr key = {eNTSOEOperationalLimitType.eNTSOEOperationalLimitTypeId}>
                                             <td> { eNTSOEOperationalLimitType.limitType } </td>
                                             <td>
                                                 <button onClick={ () => this.editENTSOEOperationalLimitType(eNTSOEOperationalLimitType.eNTSOEOperationalLimitTypeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteENTSOEOperationalLimitType(eNTSOEOperationalLimitType.eNTSOEOperationalLimitTypeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewENTSOEOperationalLimitType(eNTSOEOperationalLimitType.eNTSOEOperationalLimitTypeId)} className="btn btn-info btn-sm">View </button>
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

export default ListENTSOEOperationalLimitTypeComponent
