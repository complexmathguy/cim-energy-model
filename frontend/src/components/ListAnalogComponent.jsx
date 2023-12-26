import React, { Component } from 'react'
import AnalogService from '../services/AnalogService'

class ListAnalogComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                analogs: []
        }
        this.addAnalog = this.addAnalog.bind(this);
        this.editAnalog = this.editAnalog.bind(this);
        this.deleteAnalog = this.deleteAnalog.bind(this);
    }

    deleteAnalog(id){
        AnalogService.deleteAnalog(id).then( res => {
            this.setState({analogs: this.state.analogs.filter(analog => analog.analogId !== id)});
        });
    }
    viewAnalog(id){
        this.props.history.push(`/view-analog/${id}`);
    }
    editAnalog(id){
        this.props.history.push(`/add-analog/${id}`);
    }

    componentDidMount(){
        AnalogService.getAnalogs().then((res) => {
            this.setState({ analogs: res.data});
        });
    }

    addAnalog(){
        this.props.history.push('/add-analog/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Analog List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAnalog}> Add Analog</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> PositiveFlowIn </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.analogs.map(
                                        analog => 
                                        <tr key = {analog.analogId}>
                                             <td> { analog.positiveFlowIn } </td>
                                             <td>
                                                 <button onClick={ () => this.editAnalog(analog.analogId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAnalog(analog.analogId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnalog(analog.analogId)} className="btn btn-info btn-sm">View </button>
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

export default ListAnalogComponent
