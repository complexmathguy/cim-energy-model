import React, { Component } from 'react'
import BreakerService from '../services/BreakerService'

class ListBreakerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                breakers: []
        }
        this.addBreaker = this.addBreaker.bind(this);
        this.editBreaker = this.editBreaker.bind(this);
        this.deleteBreaker = this.deleteBreaker.bind(this);
    }

    deleteBreaker(id){
        BreakerService.deleteBreaker(id).then( res => {
            this.setState({breakers: this.state.breakers.filter(breaker => breaker.breakerId !== id)});
        });
    }
    viewBreaker(id){
        this.props.history.push(`/view-breaker/${id}`);
    }
    editBreaker(id){
        this.props.history.push(`/add-breaker/${id}`);
    }

    componentDidMount(){
        BreakerService.getBreakers().then((res) => {
            this.setState({ breakers: res.data});
        });
    }

    addBreaker(){
        this.props.history.push('/add-breaker/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Breaker List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBreaker}> Add Breaker</button>
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
                                    this.state.breakers.map(
                                        breaker => 
                                        <tr key = {breaker.breakerId}>
                                             <td>
                                                 <button onClick={ () => this.editBreaker(breaker.breakerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBreaker(breaker.breakerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBreaker(breaker.breakerId)} className="btn btn-info btn-sm">View </button>
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

export default ListBreakerComponent
