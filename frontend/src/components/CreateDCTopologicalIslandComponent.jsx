import React, { Component } from 'react'
import DCTopologicalIslandService from '../services/DCTopologicalIslandService';

class CreateDCTopologicalIslandComponent extends Component {
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
            DCTopologicalIslandService.getDCTopologicalIslandById(this.state.id).then( (res) =>{
                let dCTopologicalIsland = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCTopologicalIsland = (e) => {
        e.preventDefault();
        let dCTopologicalIsland = {
                dCTopologicalIslandId: this.state.id,
            };
        console.log('dCTopologicalIsland => ' + JSON.stringify(dCTopologicalIsland));

        // step 5
        if(this.state.id === '_add'){
            dCTopologicalIsland.dCTopologicalIslandId=''
            DCTopologicalIslandService.createDCTopologicalIsland(dCTopologicalIsland).then(res =>{
                this.props.history.push('/dCTopologicalIslands');
            });
        }else{
            DCTopologicalIslandService.updateDCTopologicalIsland(dCTopologicalIsland).then( res => {
                this.props.history.push('/dCTopologicalIslands');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCTopologicalIslands');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCTopologicalIsland</h3>
        }else{
            return <h3 className="text-center">Update DCTopologicalIsland</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCTopologicalIsland}>Save</button>
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

export default CreateDCTopologicalIslandComponent
