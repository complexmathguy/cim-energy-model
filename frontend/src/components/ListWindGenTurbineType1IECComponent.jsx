import React, { Component } from 'react'
import WindGenTurbineType1IECService from '../services/WindGenTurbineType1IECService'

class ListWindGenTurbineType1IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGenTurbineType1IECs: []
        }
        this.addWindGenTurbineType1IEC = this.addWindGenTurbineType1IEC.bind(this);
        this.editWindGenTurbineType1IEC = this.editWindGenTurbineType1IEC.bind(this);
        this.deleteWindGenTurbineType1IEC = this.deleteWindGenTurbineType1IEC.bind(this);
    }

    deleteWindGenTurbineType1IEC(id){
        WindGenTurbineType1IECService.deleteWindGenTurbineType1IEC(id).then( res => {
            this.setState({windGenTurbineType1IECs: this.state.windGenTurbineType1IECs.filter(windGenTurbineType1IEC => windGenTurbineType1IEC.windGenTurbineType1IECId !== id)});
        });
    }
    viewWindGenTurbineType1IEC(id){
        this.props.history.push(`/view-windGenTurbineType1IEC/${id}`);
    }
    editWindGenTurbineType1IEC(id){
        this.props.history.push(`/add-windGenTurbineType1IEC/${id}`);
    }

    componentDidMount(){
        WindGenTurbineType1IECService.getWindGenTurbineType1IECs().then((res) => {
            this.setState({ windGenTurbineType1IECs: res.data});
        });
    }

    addWindGenTurbineType1IEC(){
        this.props.history.push('/add-windGenTurbineType1IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGenTurbineType1IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGenTurbineType1IEC}> Add WindGenTurbineType1IEC</button>
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
                                    this.state.windGenTurbineType1IECs.map(
                                        windGenTurbineType1IEC => 
                                        <tr key = {windGenTurbineType1IEC.windGenTurbineType1IECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindGenTurbineType1IEC(windGenTurbineType1IEC.windGenTurbineType1IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGenTurbineType1IEC(windGenTurbineType1IEC.windGenTurbineType1IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGenTurbineType1IEC(windGenTurbineType1IEC.windGenTurbineType1IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGenTurbineType1IECComponent
