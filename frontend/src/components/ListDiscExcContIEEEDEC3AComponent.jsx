import React, { Component } from 'react'
import DiscExcContIEEEDEC3AService from '../services/DiscExcContIEEEDEC3AService'

class ListDiscExcContIEEEDEC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discExcContIEEEDEC3As: []
        }
        this.addDiscExcContIEEEDEC3A = this.addDiscExcContIEEEDEC3A.bind(this);
        this.editDiscExcContIEEEDEC3A = this.editDiscExcContIEEEDEC3A.bind(this);
        this.deleteDiscExcContIEEEDEC3A = this.deleteDiscExcContIEEEDEC3A.bind(this);
    }

    deleteDiscExcContIEEEDEC3A(id){
        DiscExcContIEEEDEC3AService.deleteDiscExcContIEEEDEC3A(id).then( res => {
            this.setState({discExcContIEEEDEC3As: this.state.discExcContIEEEDEC3As.filter(discExcContIEEEDEC3A => discExcContIEEEDEC3A.discExcContIEEEDEC3AId !== id)});
        });
    }
    viewDiscExcContIEEEDEC3A(id){
        this.props.history.push(`/view-discExcContIEEEDEC3A/${id}`);
    }
    editDiscExcContIEEEDEC3A(id){
        this.props.history.push(`/add-discExcContIEEEDEC3A/${id}`);
    }

    componentDidMount(){
        DiscExcContIEEEDEC3AService.getDiscExcContIEEEDEC3As().then((res) => {
            this.setState({ discExcContIEEEDEC3As: res.data});
        });
    }

    addDiscExcContIEEEDEC3A(){
        this.props.history.push('/add-discExcContIEEEDEC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscExcContIEEEDEC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscExcContIEEEDEC3A}> Add DiscExcContIEEEDEC3A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Tdr </th>
                                    <th> Vtmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.discExcContIEEEDEC3As.map(
                                        discExcContIEEEDEC3A => 
                                        <tr key = {discExcContIEEEDEC3A.discExcContIEEEDEC3AId}>
                                             <td> { discExcContIEEEDEC3A.tdr } </td>
                                             <td> { discExcContIEEEDEC3A.vtmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiscExcContIEEEDEC3A(discExcContIEEEDEC3A.discExcContIEEEDEC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscExcContIEEEDEC3A(discExcContIEEEDEC3A.discExcContIEEEDEC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscExcContIEEEDEC3A(discExcContIEEEDEC3A.discExcContIEEEDEC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscExcContIEEEDEC3AComponent
