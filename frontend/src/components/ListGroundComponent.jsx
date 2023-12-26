import React, { Component } from 'react'
import GroundService from '../services/GroundService'

class ListGroundComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                grounds: []
        }
        this.addGround = this.addGround.bind(this);
        this.editGround = this.editGround.bind(this);
        this.deleteGround = this.deleteGround.bind(this);
    }

    deleteGround(id){
        GroundService.deleteGround(id).then( res => {
            this.setState({grounds: this.state.grounds.filter(ground => ground.groundId !== id)});
        });
    }
    viewGround(id){
        this.props.history.push(`/view-ground/${id}`);
    }
    editGround(id){
        this.props.history.push(`/add-ground/${id}`);
    }

    componentDidMount(){
        GroundService.getGrounds().then((res) => {
            this.setState({ grounds: res.data});
        });
    }

    addGround(){
        this.props.history.push('/add-ground/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Ground List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGround}> Add Ground</button>
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
                                    this.state.grounds.map(
                                        ground => 
                                        <tr key = {ground.groundId}>
                                             <td>
                                                 <button onClick={ () => this.editGround(ground.groundId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGround(ground.groundId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGround(ground.groundId)} className="btn btn-info btn-sm">View </button>
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

export default ListGroundComponent
