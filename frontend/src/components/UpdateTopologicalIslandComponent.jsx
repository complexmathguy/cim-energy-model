import React, { Component } from 'react'
import TopologicalIslandService from '../services/TopologicalIslandService';

class UpdateTopologicalIslandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTopologicalIsland = this.updateTopologicalIsland.bind(this);

    }

    componentDidMount(){
        TopologicalIslandService.getTopologicalIslandById(this.state.id).then( (res) =>{
            let topologicalIsland = res.data;
            this.setState({
            });
        });
    }

    updateTopologicalIsland = (e) => {
        e.preventDefault();
        let topologicalIsland = {
            topologicalIslandId: this.state.id,
        };
        console.log('topologicalIsland => ' + JSON.stringify(topologicalIsland));
        console.log('id => ' + JSON.stringify(this.state.id));
        TopologicalIslandService.updateTopologicalIsland(topologicalIsland).then( res => {
            this.props.history.push('/topologicalIslands');
        });
    }


    cancel(){
        this.props.history.push('/topologicalIslands');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TopologicalIsland</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTopologicalIsland}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateTopologicalIslandComponent
