import React, { Component } from 'react'
import JunctionService from '../services/JunctionService'

class ListJunctionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                junctions: []
        }
        this.addJunction = this.addJunction.bind(this);
        this.editJunction = this.editJunction.bind(this);
        this.deleteJunction = this.deleteJunction.bind(this);
    }

    deleteJunction(id){
        JunctionService.deleteJunction(id).then( res => {
            this.setState({junctions: this.state.junctions.filter(junction => junction.junctionId !== id)});
        });
    }
    viewJunction(id){
        this.props.history.push(`/view-junction/${id}`);
    }
    editJunction(id){
        this.props.history.push(`/add-junction/${id}`);
    }

    componentDidMount(){
        JunctionService.getJunctions().then((res) => {
            this.setState({ junctions: res.data});
        });
    }

    addJunction(){
        this.props.history.push('/add-junction/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Junction List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addJunction}> Add Junction</button>
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
                                    this.state.junctions.map(
                                        junction => 
                                        <tr key = {junction.junctionId}>
                                             <td>
                                                 <button onClick={ () => this.editJunction(junction.junctionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteJunction(junction.junctionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewJunction(junction.junctionId)} className="btn btn-info btn-sm">View </button>
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

export default ListJunctionComponent
