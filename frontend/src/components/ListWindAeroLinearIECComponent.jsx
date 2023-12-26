import React, { Component } from 'react'
import WindAeroLinearIECService from '../services/WindAeroLinearIECService'

class ListWindAeroLinearIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windAeroLinearIECs: []
        }
        this.addWindAeroLinearIEC = this.addWindAeroLinearIEC.bind(this);
        this.editWindAeroLinearIEC = this.editWindAeroLinearIEC.bind(this);
        this.deleteWindAeroLinearIEC = this.deleteWindAeroLinearIEC.bind(this);
    }

    deleteWindAeroLinearIEC(id){
        WindAeroLinearIECService.deleteWindAeroLinearIEC(id).then( res => {
            this.setState({windAeroLinearIECs: this.state.windAeroLinearIECs.filter(windAeroLinearIEC => windAeroLinearIEC.windAeroLinearIECId !== id)});
        });
    }
    viewWindAeroLinearIEC(id){
        this.props.history.push(`/view-windAeroLinearIEC/${id}`);
    }
    editWindAeroLinearIEC(id){
        this.props.history.push(`/add-windAeroLinearIEC/${id}`);
    }

    componentDidMount(){
        WindAeroLinearIECService.getWindAeroLinearIECs().then((res) => {
            this.setState({ windAeroLinearIECs: res.data});
        });
    }

    addWindAeroLinearIEC(){
        this.props.history.push('/add-windAeroLinearIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindAeroLinearIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindAeroLinearIEC}> Add WindAeroLinearIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dpomega </th>
                                    <th> Dptheta </th>
                                    <th> Omegazero </th>
                                    <th> Pavail </th>
                                    <th> Thetazero </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windAeroLinearIECs.map(
                                        windAeroLinearIEC => 
                                        <tr key = {windAeroLinearIEC.windAeroLinearIECId}>
                                             <td> { windAeroLinearIEC.dpomega } </td>
                                             <td> { windAeroLinearIEC.dptheta } </td>
                                             <td> { windAeroLinearIEC.omegazero } </td>
                                             <td> { windAeroLinearIEC.pavail } </td>
                                             <td> { windAeroLinearIEC.thetazero } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindAeroLinearIEC(windAeroLinearIEC.windAeroLinearIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindAeroLinearIEC(windAeroLinearIEC.windAeroLinearIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindAeroLinearIEC(windAeroLinearIEC.windAeroLinearIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindAeroLinearIECComponent
