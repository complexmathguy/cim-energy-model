import React, { Component } from 'react'
import TopologicalIslandService from '../services/TopologicalIslandService';

class CreateTopologicalIslandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TopologicalIslandService.getTopologicalIslandById(this.state.id).then( (res) =>{
                let topologicalIsland = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTopologicalIsland = (e) => {
        e.preventDefault();
        let topologicalIsland = {
                topologicalIslandId: this.state.id,
            };
        console.log('topologicalIsland => ' + JSON.stringify(topologicalIsland));

        // step 5
        if(this.state.id === '_add'){
            topologicalIsland.topologicalIslandId=''
            TopologicalIslandService.createTopologicalIsland(topologicalIsland).then(res =>{
                this.props.history.push('/topologicalIslands');
            });
        }else{
            TopologicalIslandService.updateTopologicalIsland(topologicalIsland).then( res => {
                this.props.history.push('/topologicalIslands');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/topologicalIslands');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TopologicalIsland</h3>
        }else{
            return <h3 className="text-center">Update TopologicalIsland</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTopologicalIsland}>Save</button>
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

export default CreateTopologicalIslandComponent
