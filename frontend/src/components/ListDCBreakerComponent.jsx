import React, { Component } from 'react'
import DCBreakerService from '../services/DCBreakerService'

class ListDCBreakerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCBreakers: []
        }
        this.addDCBreaker = this.addDCBreaker.bind(this);
        this.editDCBreaker = this.editDCBreaker.bind(this);
        this.deleteDCBreaker = this.deleteDCBreaker.bind(this);
    }

    deleteDCBreaker(id){
        DCBreakerService.deleteDCBreaker(id).then( res => {
            this.setState({dCBreakers: this.state.dCBreakers.filter(dCBreaker => dCBreaker.dCBreakerId !== id)});
        });
    }
    viewDCBreaker(id){
        this.props.history.push(`/view-dCBreaker/${id}`);
    }
    editDCBreaker(id){
        this.props.history.push(`/add-dCBreaker/${id}`);
    }

    componentDidMount(){
        DCBreakerService.getDCBreakers().then((res) => {
            this.setState({ dCBreakers: res.data});
        });
    }

    addDCBreaker(){
        this.props.history.push('/add-dCBreaker/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCBreaker List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCBreaker}> Add DCBreaker</button>
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
                                    this.state.dCBreakers.map(
                                        dCBreaker => 
                                        <tr key = {dCBreaker.dCBreakerId}>
                                             <td>
                                                 <button onClick={ () => this.editDCBreaker(dCBreaker.dCBreakerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCBreaker(dCBreaker.dCBreakerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCBreaker(dCBreaker.dCBreakerId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCBreakerComponent
