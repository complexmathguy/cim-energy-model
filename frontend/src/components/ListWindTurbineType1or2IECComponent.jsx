import React, { Component } from 'react'
import WindTurbineType1or2IECService from '../services/WindTurbineType1or2IECService'

class ListWindTurbineType1or2IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windTurbineType1or2IECs: []
        }
        this.addWindTurbineType1or2IEC = this.addWindTurbineType1or2IEC.bind(this);
        this.editWindTurbineType1or2IEC = this.editWindTurbineType1or2IEC.bind(this);
        this.deleteWindTurbineType1or2IEC = this.deleteWindTurbineType1or2IEC.bind(this);
    }

    deleteWindTurbineType1or2IEC(id){
        WindTurbineType1or2IECService.deleteWindTurbineType1or2IEC(id).then( res => {
            this.setState({windTurbineType1or2IECs: this.state.windTurbineType1or2IECs.filter(windTurbineType1or2IEC => windTurbineType1or2IEC.windTurbineType1or2IECId !== id)});
        });
    }
    viewWindTurbineType1or2IEC(id){
        this.props.history.push(`/view-windTurbineType1or2IEC/${id}`);
    }
    editWindTurbineType1or2IEC(id){
        this.props.history.push(`/add-windTurbineType1or2IEC/${id}`);
    }

    componentDidMount(){
        WindTurbineType1or2IECService.getWindTurbineType1or2IECs().then((res) => {
            this.setState({ windTurbineType1or2IECs: res.data});
        });
    }

    addWindTurbineType1or2IEC(){
        this.props.history.push('/add-windTurbineType1or2IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindTurbineType1or2IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindTurbineType1or2IEC}> Add WindTurbineType1or2IEC</button>
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
                                    this.state.windTurbineType1or2IECs.map(
                                        windTurbineType1or2IEC => 
                                        <tr key = {windTurbineType1or2IEC.windTurbineType1or2IECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindTurbineType1or2IEC(windTurbineType1or2IEC.windTurbineType1or2IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindTurbineType1or2IEC(windTurbineType1or2IEC.windTurbineType1or2IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindTurbineType1or2IEC(windTurbineType1or2IEC.windTurbineType1or2IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindTurbineType1or2IECComponent
