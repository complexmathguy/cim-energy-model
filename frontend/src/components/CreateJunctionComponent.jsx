import React, { Component } from 'react'
import JunctionService from '../services/JunctionService';

class CreateJunctionComponent extends Component {
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
            JunctionService.getJunctionById(this.state.id).then( (res) =>{
                let junction = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateJunction = (e) => {
        e.preventDefault();
        let junction = {
                junctionId: this.state.id,
            };
        console.log('junction => ' + JSON.stringify(junction));

        // step 5
        if(this.state.id === '_add'){
            junction.junctionId=''
            JunctionService.createJunction(junction).then(res =>{
                this.props.history.push('/junctions');
            });
        }else{
            JunctionService.updateJunction(junction).then( res => {
                this.props.history.push('/junctions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/junctions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Junction</h3>
        }else{
            return <h3 className="text-center">Update Junction</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateJunction}>Save</button>
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

export default CreateJunctionComponent
