import React, { Component } from 'react'
import WindPlantIECService from '../services/WindPlantIECService'

class ListWindPlantIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windPlantIECs: []
        }
        this.addWindPlantIEC = this.addWindPlantIEC.bind(this);
        this.editWindPlantIEC = this.editWindPlantIEC.bind(this);
        this.deleteWindPlantIEC = this.deleteWindPlantIEC.bind(this);
    }

    deleteWindPlantIEC(id){
        WindPlantIECService.deleteWindPlantIEC(id).then( res => {
            this.setState({windPlantIECs: this.state.windPlantIECs.filter(windPlantIEC => windPlantIEC.windPlantIECId !== id)});
        });
    }
    viewWindPlantIEC(id){
        this.props.history.push(`/view-windPlantIEC/${id}`);
    }
    editWindPlantIEC(id){
        this.props.history.push(`/add-windPlantIEC/${id}`);
    }

    componentDidMount(){
        WindPlantIECService.getWindPlantIECs().then((res) => {
            this.setState({ windPlantIECs: res.data});
        });
    }

    addWindPlantIEC(){
        this.props.history.push('/add-windPlantIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindPlantIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindPlantIEC}> Add WindPlantIEC</button>
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
                                    this.state.windPlantIECs.map(
                                        windPlantIEC => 
                                        <tr key = {windPlantIEC.windPlantIECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindPlantIEC(windPlantIEC.windPlantIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindPlantIEC(windPlantIEC.windPlantIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindPlantIEC(windPlantIEC.windPlantIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindPlantIECComponent
