import React, { Component } from 'react'
import StringMeasurementService from '../services/StringMeasurementService'

class ListStringMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                stringMeasurements: []
        }
        this.addStringMeasurement = this.addStringMeasurement.bind(this);
        this.editStringMeasurement = this.editStringMeasurement.bind(this);
        this.deleteStringMeasurement = this.deleteStringMeasurement.bind(this);
    }

    deleteStringMeasurement(id){
        StringMeasurementService.deleteStringMeasurement(id).then( res => {
            this.setState({stringMeasurements: this.state.stringMeasurements.filter(stringMeasurement => stringMeasurement.stringMeasurementId !== id)});
        });
    }
    viewStringMeasurement(id){
        this.props.history.push(`/view-stringMeasurement/${id}`);
    }
    editStringMeasurement(id){
        this.props.history.push(`/add-stringMeasurement/${id}`);
    }

    componentDidMount(){
        StringMeasurementService.getStringMeasurements().then((res) => {
            this.setState({ stringMeasurements: res.data});
        });
    }

    addStringMeasurement(){
        this.props.history.push('/add-stringMeasurement/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">StringMeasurement List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStringMeasurement}> Add StringMeasurement</button>
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
                                    this.state.stringMeasurements.map(
                                        stringMeasurement => 
                                        <tr key = {stringMeasurement.stringMeasurementId}>
                                             <td>
                                                 <button onClick={ () => this.editStringMeasurement(stringMeasurement.stringMeasurementId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStringMeasurement(stringMeasurement.stringMeasurementId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStringMeasurement(stringMeasurement.stringMeasurementId)} className="btn btn-info btn-sm">View </button>
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

export default ListStringMeasurementComponent
