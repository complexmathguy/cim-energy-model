import React, { Component } from 'react'
import WindGenTurbineType2IECService from '../services/WindGenTurbineType2IECService'

class ListWindGenTurbineType2IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGenTurbineType2IECs: []
        }
        this.addWindGenTurbineType2IEC = this.addWindGenTurbineType2IEC.bind(this);
        this.editWindGenTurbineType2IEC = this.editWindGenTurbineType2IEC.bind(this);
        this.deleteWindGenTurbineType2IEC = this.deleteWindGenTurbineType2IEC.bind(this);
    }

    deleteWindGenTurbineType2IEC(id){
        WindGenTurbineType2IECService.deleteWindGenTurbineType2IEC(id).then( res => {
            this.setState({windGenTurbineType2IECs: this.state.windGenTurbineType2IECs.filter(windGenTurbineType2IEC => windGenTurbineType2IEC.windGenTurbineType2IECId !== id)});
        });
    }
    viewWindGenTurbineType2IEC(id){
        this.props.history.push(`/view-windGenTurbineType2IEC/${id}`);
    }
    editWindGenTurbineType2IEC(id){
        this.props.history.push(`/add-windGenTurbineType2IEC/${id}`);
    }

    componentDidMount(){
        WindGenTurbineType2IECService.getWindGenTurbineType2IECs().then((res) => {
            this.setState({ windGenTurbineType2IECs: res.data});
        });
    }

    addWindGenTurbineType2IEC(){
        this.props.history.push('/add-windGenTurbineType2IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGenTurbineType2IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGenTurbineType2IEC}> Add WindGenTurbineType2IEC</button>
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
                                    this.state.windGenTurbineType2IECs.map(
                                        windGenTurbineType2IEC => 
                                        <tr key = {windGenTurbineType2IEC.windGenTurbineType2IECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindGenTurbineType2IEC(windGenTurbineType2IEC.windGenTurbineType2IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGenTurbineType2IEC(windGenTurbineType2IEC.windGenTurbineType2IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGenTurbineType2IEC(windGenTurbineType2IEC.windGenTurbineType2IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGenTurbineType2IECComponent
