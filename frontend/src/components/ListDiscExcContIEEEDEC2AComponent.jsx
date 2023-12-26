import React, { Component } from 'react'
import DiscExcContIEEEDEC2AService from '../services/DiscExcContIEEEDEC2AService'

class ListDiscExcContIEEEDEC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discExcContIEEEDEC2As: []
        }
        this.addDiscExcContIEEEDEC2A = this.addDiscExcContIEEEDEC2A.bind(this);
        this.editDiscExcContIEEEDEC2A = this.editDiscExcContIEEEDEC2A.bind(this);
        this.deleteDiscExcContIEEEDEC2A = this.deleteDiscExcContIEEEDEC2A.bind(this);
    }

    deleteDiscExcContIEEEDEC2A(id){
        DiscExcContIEEEDEC2AService.deleteDiscExcContIEEEDEC2A(id).then( res => {
            this.setState({discExcContIEEEDEC2As: this.state.discExcContIEEEDEC2As.filter(discExcContIEEEDEC2A => discExcContIEEEDEC2A.discExcContIEEEDEC2AId !== id)});
        });
    }
    viewDiscExcContIEEEDEC2A(id){
        this.props.history.push(`/view-discExcContIEEEDEC2A/${id}`);
    }
    editDiscExcContIEEEDEC2A(id){
        this.props.history.push(`/add-discExcContIEEEDEC2A/${id}`);
    }

    componentDidMount(){
        DiscExcContIEEEDEC2AService.getDiscExcContIEEEDEC2As().then((res) => {
            this.setState({ discExcContIEEEDEC2As: res.data});
        });
    }

    addDiscExcContIEEEDEC2A(){
        this.props.history.push('/add-discExcContIEEEDEC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscExcContIEEEDEC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscExcContIEEEDEC2A}> Add DiscExcContIEEEDEC2A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Td1 </th>
                                    <th> Td2 </th>
                                    <th> Vdmax </th>
                                    <th> Vdmin </th>
                                    <th> Vk </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.discExcContIEEEDEC2As.map(
                                        discExcContIEEEDEC2A => 
                                        <tr key = {discExcContIEEEDEC2A.discExcContIEEEDEC2AId}>
                                             <td> { discExcContIEEEDEC2A.td1 } </td>
                                             <td> { discExcContIEEEDEC2A.td2 } </td>
                                             <td> { discExcContIEEEDEC2A.vdmax } </td>
                                             <td> { discExcContIEEEDEC2A.vdmin } </td>
                                             <td> { discExcContIEEEDEC2A.vk } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiscExcContIEEEDEC2A(discExcContIEEEDEC2A.discExcContIEEEDEC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscExcContIEEEDEC2A(discExcContIEEEDEC2A.discExcContIEEEDEC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscExcContIEEEDEC2A(discExcContIEEEDEC2A.discExcContIEEEDEC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscExcContIEEEDEC2AComponent
