import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService'

class ListWindProtectionIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windProtectionIECs: []
        }
        this.addWindProtectionIEC = this.addWindProtectionIEC.bind(this);
        this.editWindProtectionIEC = this.editWindProtectionIEC.bind(this);
        this.deleteWindProtectionIEC = this.deleteWindProtectionIEC.bind(this);
    }

    deleteWindProtectionIEC(id){
        WindProtectionIECService.deleteWindProtectionIEC(id).then( res => {
            this.setState({windProtectionIECs: this.state.windProtectionIECs.filter(windProtectionIEC => windProtectionIEC.windProtectionIECId !== id)});
        });
    }
    viewWindProtectionIEC(id){
        this.props.history.push(`/view-windProtectionIEC/${id}`);
    }
    editWindProtectionIEC(id){
        this.props.history.push(`/add-windProtectionIEC/${id}`);
    }

    componentDidMount(){
        WindProtectionIECService.getWindProtectionIECs().then((res) => {
            this.setState({ windProtectionIECs: res.data});
        });
    }

    addWindProtectionIEC(){
        this.props.history.push('/add-windProtectionIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindProtectionIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindProtectionIEC}> Add WindProtectionIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Fover </th>
                                    <th> Funder </th>
                                    <th> Tfover </th>
                                    <th> Tfunder </th>
                                    <th> Tuover </th>
                                    <th> Tuunder </th>
                                    <th> Uover </th>
                                    <th> Uunder </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windProtectionIECs.map(
                                        windProtectionIEC => 
                                        <tr key = {windProtectionIEC.windProtectionIECId}>
                                             <td> { windProtectionIEC.fover } </td>
                                             <td> { windProtectionIEC.funder } </td>
                                             <td> { windProtectionIEC.tfover } </td>
                                             <td> { windProtectionIEC.tfunder } </td>
                                             <td> { windProtectionIEC.tuover } </td>
                                             <td> { windProtectionIEC.tuunder } </td>
                                             <td> { windProtectionIEC.uover } </td>
                                             <td> { windProtectionIEC.uunder } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindProtectionIEC(windProtectionIEC.windProtectionIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindProtectionIEC(windProtectionIEC.windProtectionIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindProtectionIEC(windProtectionIEC.windProtectionIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindProtectionIECComponent
