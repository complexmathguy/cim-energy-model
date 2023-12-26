import React, { Component } from 'react'
import FossilFuelService from '../services/FossilFuelService'

class ListFossilFuelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                fossilFuels: []
        }
        this.addFossilFuel = this.addFossilFuel.bind(this);
        this.editFossilFuel = this.editFossilFuel.bind(this);
        this.deleteFossilFuel = this.deleteFossilFuel.bind(this);
    }

    deleteFossilFuel(id){
        FossilFuelService.deleteFossilFuel(id).then( res => {
            this.setState({fossilFuels: this.state.fossilFuels.filter(fossilFuel => fossilFuel.fossilFuelId !== id)});
        });
    }
    viewFossilFuel(id){
        this.props.history.push(`/view-fossilFuel/${id}`);
    }
    editFossilFuel(id){
        this.props.history.push(`/add-fossilFuel/${id}`);
    }

    componentDidMount(){
        FossilFuelService.getFossilFuels().then((res) => {
            this.setState({ fossilFuels: res.data});
        });
    }

    addFossilFuel(){
        this.props.history.push('/add-fossilFuel/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">FossilFuel List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addFossilFuel}> Add FossilFuel</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> FossilFuelType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.fossilFuels.map(
                                        fossilFuel => 
                                        <tr key = {fossilFuel.fossilFuelId}>
                                             <td> { fossilFuel.fossilFuelType } </td>
                                             <td>
                                                 <button onClick={ () => this.editFossilFuel(fossilFuel.fossilFuelId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteFossilFuel(fossilFuel.fossilFuelId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewFossilFuel(fossilFuel.fossilFuelId)} className="btn btn-info btn-sm">View </button>
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

export default ListFossilFuelComponent
