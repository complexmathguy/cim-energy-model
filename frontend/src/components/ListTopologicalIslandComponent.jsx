import React, { Component } from 'react'
import TopologicalIslandService from '../services/TopologicalIslandService'

class ListTopologicalIslandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                topologicalIslands: []
        }
        this.addTopologicalIsland = this.addTopologicalIsland.bind(this);
        this.editTopologicalIsland = this.editTopologicalIsland.bind(this);
        this.deleteTopologicalIsland = this.deleteTopologicalIsland.bind(this);
    }

    deleteTopologicalIsland(id){
        TopologicalIslandService.deleteTopologicalIsland(id).then( res => {
            this.setState({topologicalIslands: this.state.topologicalIslands.filter(topologicalIsland => topologicalIsland.topologicalIslandId !== id)});
        });
    }
    viewTopologicalIsland(id){
        this.props.history.push(`/view-topologicalIsland/${id}`);
    }
    editTopologicalIsland(id){
        this.props.history.push(`/add-topologicalIsland/${id}`);
    }

    componentDidMount(){
        TopologicalIslandService.getTopologicalIslands().then((res) => {
            this.setState({ topologicalIslands: res.data});
        });
    }

    addTopologicalIsland(){
        this.props.history.push('/add-topologicalIsland/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TopologicalIsland List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTopologicalIsland}> Add TopologicalIsland</button>
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
                                    this.state.topologicalIslands.map(
                                        topologicalIsland => 
                                        <tr key = {topologicalIsland.topologicalIslandId}>
                                             <td>
                                                 <button onClick={ () => this.editTopologicalIsland(topologicalIsland.topologicalIslandId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTopologicalIsland(topologicalIsland.topologicalIslandId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTopologicalIsland(topologicalIsland.topologicalIslandId)} className="btn btn-info btn-sm">View </button>
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

export default ListTopologicalIslandComponent
