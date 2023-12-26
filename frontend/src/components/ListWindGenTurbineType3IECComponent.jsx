import React, { Component } from 'react'
import WindGenTurbineType3IECService from '../services/WindGenTurbineType3IECService'

class ListWindGenTurbineType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGenTurbineType3IECs: []
        }
        this.addWindGenTurbineType3IEC = this.addWindGenTurbineType3IEC.bind(this);
        this.editWindGenTurbineType3IEC = this.editWindGenTurbineType3IEC.bind(this);
        this.deleteWindGenTurbineType3IEC = this.deleteWindGenTurbineType3IEC.bind(this);
    }

    deleteWindGenTurbineType3IEC(id){
        WindGenTurbineType3IECService.deleteWindGenTurbineType3IEC(id).then( res => {
            this.setState({windGenTurbineType3IECs: this.state.windGenTurbineType3IECs.filter(windGenTurbineType3IEC => windGenTurbineType3IEC.windGenTurbineType3IECId !== id)});
        });
    }
    viewWindGenTurbineType3IEC(id){
        this.props.history.push(`/view-windGenTurbineType3IEC/${id}`);
    }
    editWindGenTurbineType3IEC(id){
        this.props.history.push(`/add-windGenTurbineType3IEC/${id}`);
    }

    componentDidMount(){
        WindGenTurbineType3IECService.getWindGenTurbineType3IECs().then((res) => {
            this.setState({ windGenTurbineType3IECs: res.data});
        });
    }

    addWindGenTurbineType3IEC(){
        this.props.history.push('/add-windGenTurbineType3IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGenTurbineType3IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGenTurbineType3IEC}> Add WindGenTurbineType3IEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dipmax </th>
                                    <th> Diqmax </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windGenTurbineType3IECs.map(
                                        windGenTurbineType3IEC => 
                                        <tr key = {windGenTurbineType3IEC.windGenTurbineType3IECId}>
                                             <td> { windGenTurbineType3IEC.dipmax } </td>
                                             <td> { windGenTurbineType3IEC.diqmax } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindGenTurbineType3IEC(windGenTurbineType3IEC.windGenTurbineType3IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGenTurbineType3IEC(windGenTurbineType3IEC.windGenTurbineType3IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGenTurbineType3IEC(windGenTurbineType3IEC.windGenTurbineType3IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGenTurbineType3IECComponent
