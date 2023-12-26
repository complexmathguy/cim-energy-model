import React, { Component } from 'react'
import DCTopologicalIslandService from '../services/DCTopologicalIslandService';

class UpdateDCTopologicalIslandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCTopologicalIsland = this.updateDCTopologicalIsland.bind(this);

    }

    componentDidMount(){
        DCTopologicalIslandService.getDCTopologicalIslandById(this.state.id).then( (res) =>{
            let dCTopologicalIsland = res.data;
            this.setState({
            });
        });
    }

    updateDCTopologicalIsland = (e) => {
        e.preventDefault();
        let dCTopologicalIsland = {
            dCTopologicalIslandId: this.state.id,
        };
        console.log('dCTopologicalIsland => ' + JSON.stringify(dCTopologicalIsland));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCTopologicalIslandService.updateDCTopologicalIsland(dCTopologicalIsland).then( res => {
            this.props.history.push('/dCTopologicalIslands');
        });
    }


    cancel(){
        this.props.history.push('/dCTopologicalIslands');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCTopologicalIsland</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCTopologicalIsland}>Save</button>
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

export default UpdateDCTopologicalIslandComponent
