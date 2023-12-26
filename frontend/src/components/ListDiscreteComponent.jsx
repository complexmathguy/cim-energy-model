import React, { Component } from 'react'
import DiscreteService from '../services/DiscreteService'

class ListDiscreteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discretes: []
        }
        this.addDiscrete = this.addDiscrete.bind(this);
        this.editDiscrete = this.editDiscrete.bind(this);
        this.deleteDiscrete = this.deleteDiscrete.bind(this);
    }

    deleteDiscrete(id){
        DiscreteService.deleteDiscrete(id).then( res => {
            this.setState({discretes: this.state.discretes.filter(discrete => discrete.discreteId !== id)});
        });
    }
    viewDiscrete(id){
        this.props.history.push(`/view-discrete/${id}`);
    }
    editDiscrete(id){
        this.props.history.push(`/add-discrete/${id}`);
    }

    componentDidMount(){
        DiscreteService.getDiscretes().then((res) => {
            this.setState({ discretes: res.data});
        });
    }

    addDiscrete(){
        this.props.history.push('/add-discrete/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Discrete List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscrete}> Add Discrete</button>
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
                                    this.state.discretes.map(
                                        discrete => 
                                        <tr key = {discrete.discreteId}>
                                             <td>
                                                 <button onClick={ () => this.editDiscrete(discrete.discreteId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscrete(discrete.discreteId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscrete(discrete.discreteId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscreteComponent
