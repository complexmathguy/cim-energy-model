import React, { Component } from 'react'
import WindTurbineType4aIECService from '../services/WindTurbineType4aIECService'

class ListWindTurbineType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windTurbineType4aIECs: []
        }
        this.addWindTurbineType4aIEC = this.addWindTurbineType4aIEC.bind(this);
        this.editWindTurbineType4aIEC = this.editWindTurbineType4aIEC.bind(this);
        this.deleteWindTurbineType4aIEC = this.deleteWindTurbineType4aIEC.bind(this);
    }

    deleteWindTurbineType4aIEC(id){
        WindTurbineType4aIECService.deleteWindTurbineType4aIEC(id).then( res => {
            this.setState({windTurbineType4aIECs: this.state.windTurbineType4aIECs.filter(windTurbineType4aIEC => windTurbineType4aIEC.windTurbineType4aIECId !== id)});
        });
    }
    viewWindTurbineType4aIEC(id){
        this.props.history.push(`/view-windTurbineType4aIEC/${id}`);
    }
    editWindTurbineType4aIEC(id){
        this.props.history.push(`/add-windTurbineType4aIEC/${id}`);
    }

    componentDidMount(){
        WindTurbineType4aIECService.getWindTurbineType4aIECs().then((res) => {
            this.setState({ windTurbineType4aIECs: res.data});
        });
    }

    addWindTurbineType4aIEC(){
        this.props.history.push('/add-windTurbineType4aIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindTurbineType4aIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindTurbineType4aIEC}> Add WindTurbineType4aIEC</button>
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
                                    this.state.windTurbineType4aIECs.map(
                                        windTurbineType4aIEC => 
                                        <tr key = {windTurbineType4aIEC.windTurbineType4aIECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindTurbineType4aIEC(windTurbineType4aIEC.windTurbineType4aIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindTurbineType4aIEC(windTurbineType4aIEC.windTurbineType4aIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindTurbineType4aIEC(windTurbineType4aIEC.windTurbineType4aIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindTurbineType4aIECComponent
