import React, { Component } from 'react'
import HydroPumpService from '../services/HydroPumpService';

class CreateHydroPumpComponent extends Component {
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
            HydroPumpService.getHydroPumpById(this.state.id).then( (res) =>{
                let hydroPump = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateHydroPump = (e) => {
        e.preventDefault();
        let hydroPump = {
                hydroPumpId: this.state.id,
            };
        console.log('hydroPump => ' + JSON.stringify(hydroPump));

        // step 5
        if(this.state.id === '_add'){
            hydroPump.hydroPumpId=''
            HydroPumpService.createHydroPump(hydroPump).then(res =>{
                this.props.history.push('/hydroPumps');
            });
        }else{
            HydroPumpService.updateHydroPump(hydroPump).then( res => {
                this.props.history.push('/hydroPumps');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/hydroPumps');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add HydroPump</h3>
        }else{
            return <h3 className="text-center">Update HydroPump</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateHydroPump}>Save</button>
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

export default CreateHydroPumpComponent
