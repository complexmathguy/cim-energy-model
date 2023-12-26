import React, { Component } from 'react'
import WindTurbineType3or4IECService from '../services/WindTurbineType3or4IECService'

class ListWindTurbineType3or4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windTurbineType3or4IECs: []
        }
        this.addWindTurbineType3or4IEC = this.addWindTurbineType3or4IEC.bind(this);
        this.editWindTurbineType3or4IEC = this.editWindTurbineType3or4IEC.bind(this);
        this.deleteWindTurbineType3or4IEC = this.deleteWindTurbineType3or4IEC.bind(this);
    }

    deleteWindTurbineType3or4IEC(id){
        WindTurbineType3or4IECService.deleteWindTurbineType3or4IEC(id).then( res => {
            this.setState({windTurbineType3or4IECs: this.state.windTurbineType3or4IECs.filter(windTurbineType3or4IEC => windTurbineType3or4IEC.windTurbineType3or4IECId !== id)});
        });
    }
    viewWindTurbineType3or4IEC(id){
        this.props.history.push(`/view-windTurbineType3or4IEC/${id}`);
    }
    editWindTurbineType3or4IEC(id){
        this.props.history.push(`/add-windTurbineType3or4IEC/${id}`);
    }

    componentDidMount(){
        WindTurbineType3or4IECService.getWindTurbineType3or4IECs().then((res) => {
            this.setState({ windTurbineType3or4IECs: res.data});
        });
    }

    addWindTurbineType3or4IEC(){
        this.props.history.push('/add-windTurbineType3or4IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindTurbineType3or4IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindTurbineType3or4IEC}> Add WindTurbineType3or4IEC</button>
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
                                    this.state.windTurbineType3or4IECs.map(
                                        windTurbineType3or4IEC => 
                                        <tr key = {windTurbineType3or4IEC.windTurbineType3or4IECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindTurbineType3or4IEC(windTurbineType3or4IEC.windTurbineType3or4IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindTurbineType3or4IEC(windTurbineType3or4IEC.windTurbineType3or4IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindTurbineType3or4IEC(windTurbineType3or4IEC.windTurbineType3or4IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindTurbineType3or4IECComponent
