import React, { Component } from 'react'
import WindGenTurbineType3aIECService from '../services/WindGenTurbineType3aIECService'

class ListWindGenTurbineType3aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGenTurbineType3aIECs: []
        }
        this.addWindGenTurbineType3aIEC = this.addWindGenTurbineType3aIEC.bind(this);
        this.editWindGenTurbineType3aIEC = this.editWindGenTurbineType3aIEC.bind(this);
        this.deleteWindGenTurbineType3aIEC = this.deleteWindGenTurbineType3aIEC.bind(this);
    }

    deleteWindGenTurbineType3aIEC(id){
        WindGenTurbineType3aIECService.deleteWindGenTurbineType3aIEC(id).then( res => {
            this.setState({windGenTurbineType3aIECs: this.state.windGenTurbineType3aIECs.filter(windGenTurbineType3aIEC => windGenTurbineType3aIEC.windGenTurbineType3aIECId !== id)});
        });
    }
    viewWindGenTurbineType3aIEC(id){
        this.props.history.push(`/view-windGenTurbineType3aIEC/${id}`);
    }
    editWindGenTurbineType3aIEC(id){
        this.props.history.push(`/add-windGenTurbineType3aIEC/${id}`);
    }

    componentDidMount(){
        WindGenTurbineType3aIECService.getWindGenTurbineType3aIECs().then((res) => {
            this.setState({ windGenTurbineType3aIECs: res.data});
        });
    }

    addWindGenTurbineType3aIEC(){
        this.props.history.push('/add-windGenTurbineType3aIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGenTurbineType3aIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGenTurbineType3aIEC}> Add WindGenTurbineType3aIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kpc </th>
                                    <th> Tic </th>
                                    <th> Xs </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windGenTurbineType3aIECs.map(
                                        windGenTurbineType3aIEC => 
                                        <tr key = {windGenTurbineType3aIEC.windGenTurbineType3aIECId}>
                                             <td> { windGenTurbineType3aIEC.kpc } </td>
                                             <td> { windGenTurbineType3aIEC.tic } </td>
                                             <td> { windGenTurbineType3aIEC.xs } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindGenTurbineType3aIEC(windGenTurbineType3aIEC.windGenTurbineType3aIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGenTurbineType3aIEC(windGenTurbineType3aIEC.windGenTurbineType3aIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGenTurbineType3aIEC(windGenTurbineType3aIEC.windGenTurbineType3aIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGenTurbineType3aIECComponent
