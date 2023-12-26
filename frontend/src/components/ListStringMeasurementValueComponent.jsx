import React, { Component } from 'react'
import StringMeasurementValueService from '../services/StringMeasurementValueService'

class ListStringMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                stringMeasurementValues: []
        }
        this.addStringMeasurementValue = this.addStringMeasurementValue.bind(this);
        this.editStringMeasurementValue = this.editStringMeasurementValue.bind(this);
        this.deleteStringMeasurementValue = this.deleteStringMeasurementValue.bind(this);
    }

    deleteStringMeasurementValue(id){
        StringMeasurementValueService.deleteStringMeasurementValue(id).then( res => {
            this.setState({stringMeasurementValues: this.state.stringMeasurementValues.filter(stringMeasurementValue => stringMeasurementValue.stringMeasurementValueId !== id)});
        });
    }
    viewStringMeasurementValue(id){
        this.props.history.push(`/view-stringMeasurementValue/${id}`);
    }
    editStringMeasurementValue(id){
        this.props.history.push(`/add-stringMeasurementValue/${id}`);
    }

    componentDidMount(){
        StringMeasurementValueService.getStringMeasurementValues().then((res) => {
            this.setState({ stringMeasurementValues: res.data});
        });
    }

    addStringMeasurementValue(){
        this.props.history.push('/add-stringMeasurementValue/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">StringMeasurementValue List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStringMeasurementValue}> Add StringMeasurementValue</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.stringMeasurementValues.map(
                                        stringMeasurementValue => 
                                        <tr key = {stringMeasurementValue.stringMeasurementValueId}>
                                             <td> { stringMeasurementValue.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editStringMeasurementValue(stringMeasurementValue.stringMeasurementValueId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStringMeasurementValue(stringMeasurementValue.stringMeasurementValueId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStringMeasurementValue(stringMeasurementValue.stringMeasurementValueId)} className="btn btn-info btn-sm">View </button>
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

export default ListStringMeasurementValueComponent
