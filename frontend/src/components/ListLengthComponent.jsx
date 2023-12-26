import React, { Component } from 'react'
import LengthService from '../services/LengthService'

class ListLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                lengths: []
        }
        this.addLength = this.addLength.bind(this);
        this.editLength = this.editLength.bind(this);
        this.deleteLength = this.deleteLength.bind(this);
    }

    deleteLength(id){
        LengthService.deleteLength(id).then( res => {
            this.setState({lengths: this.state.lengths.filter(length => length.lengthId !== id)});
        });
    }
    viewLength(id){
        this.props.history.push(`/view-length/${id}`);
    }
    editLength(id){
        this.props.history.push(`/add-length/${id}`);
    }

    componentDidMount(){
        LengthService.getLengths().then((res) => {
            this.setState({ lengths: res.data});
        });
    }

    addLength(){
        this.props.history.push('/add-length/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Length List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLength}> Add Length</button>
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
                                    this.state.lengths.map(
                                        length => 
                                        <tr key = {length.lengthId}>
                                             <td> { length.multiplier } </td>
                                             <td> { length.unit } </td>
                                             <td> { length.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editLength(length.lengthId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLength(length.lengthId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLength(length.lengthId)} className="btn btn-info btn-sm">View </button>
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

export default ListLengthComponent
