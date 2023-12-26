import React, { Component } from 'react'
import WindTurbineType4bIECService from '../services/WindTurbineType4bIECService'

class ListWindTurbineType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windTurbineType4bIECs: []
        }
        this.addWindTurbineType4bIEC = this.addWindTurbineType4bIEC.bind(this);
        this.editWindTurbineType4bIEC = this.editWindTurbineType4bIEC.bind(this);
        this.deleteWindTurbineType4bIEC = this.deleteWindTurbineType4bIEC.bind(this);
    }

    deleteWindTurbineType4bIEC(id){
        WindTurbineType4bIECService.deleteWindTurbineType4bIEC(id).then( res => {
            this.setState({windTurbineType4bIECs: this.state.windTurbineType4bIECs.filter(windTurbineType4bIEC => windTurbineType4bIEC.windTurbineType4bIECId !== id)});
        });
    }
    viewWindTurbineType4bIEC(id){
        this.props.history.push(`/view-windTurbineType4bIEC/${id}`);
    }
    editWindTurbineType4bIEC(id){
        this.props.history.push(`/add-windTurbineType4bIEC/${id}`);
    }

    componentDidMount(){
        WindTurbineType4bIECService.getWindTurbineType4bIECs().then((res) => {
            this.setState({ windTurbineType4bIECs: res.data});
        });
    }

    addWindTurbineType4bIEC(){
        this.props.history.push('/add-windTurbineType4bIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindTurbineType4bIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindTurbineType4bIEC}> Add WindTurbineType4bIEC</button>
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
                                    this.state.windTurbineType4bIECs.map(
                                        windTurbineType4bIEC => 
                                        <tr key = {windTurbineType4bIEC.windTurbineType4bIECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindTurbineType4bIEC(windTurbineType4bIEC.windTurbineType4bIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindTurbineType4bIEC(windTurbineType4bIEC.windTurbineType4bIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindTurbineType4bIEC(windTurbineType4bIEC.windTurbineType4bIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindTurbineType4bIECComponent
