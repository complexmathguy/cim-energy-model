import React, { Component } from 'react'
import GroundService from '../services/GroundService';

class CreateGroundComponent extends Component {
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
            GroundService.getGroundById(this.state.id).then( (res) =>{
                let ground = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGround = (e) => {
        e.preventDefault();
        let ground = {
                groundId: this.state.id,
            };
        console.log('ground => ' + JSON.stringify(ground));

        // step 5
        if(this.state.id === '_add'){
            ground.groundId=''
            GroundService.createGround(ground).then(res =>{
                this.props.history.push('/grounds');
            });
        }else{
            GroundService.updateGround(ground).then( res => {
                this.props.history.push('/grounds');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/grounds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Ground</h3>
        }else{
            return <h3 className="text-center">Update Ground</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGround}>Save</button>
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

export default CreateGroundComponent
