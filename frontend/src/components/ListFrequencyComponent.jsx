import React, { Component } from 'react'
import FrequencyService from '../services/FrequencyService'

class ListFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                frequencys: []
        }
        this.addFrequency = this.addFrequency.bind(this);
        this.editFrequency = this.editFrequency.bind(this);
        this.deleteFrequency = this.deleteFrequency.bind(this);
    }

    deleteFrequency(id){
        FrequencyService.deleteFrequency(id).then( res => {
            this.setState({frequencys: this.state.frequencys.filter(frequency => frequency.frequencyId !== id)});
        });
    }
    viewFrequency(id){
        this.props.history.push(`/view-frequency/${id}`);
    }
    editFrequency(id){
        this.props.history.push(`/add-frequency/${id}`);
    }

    componentDidMount(){
        FrequencyService.getFrequencys().then((res) => {
            this.setState({ frequencys: res.data});
        });
    }

    addFrequency(){
        this.props.history.push('/add-frequency/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Frequency List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addFrequency}> Add Frequency</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.frequencys.map(
                                        frequency => 
                                        <tr key = {frequency.frequencyId}>
                                             <td> { frequency.multiplier } </td>
                                             <td> { frequency.unit } </td>
                                             <td> { frequency.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editFrequency(frequency.frequencyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteFrequency(frequency.frequencyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewFrequency(frequency.frequencyId)} className="btn btn-info btn-sm">View </button>
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

export default ListFrequencyComponent
